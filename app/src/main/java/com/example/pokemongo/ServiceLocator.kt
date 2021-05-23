package com.example.pokemongo

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import com.example.pokemongo.data.local.PokemonDatabase
import com.example.pokemongo.data.remote.PokemonService
import com.example.pokemongo.data.remote.TokenService
import com.example.pokemongo.repositories.DefaultPokemonRepository
import com.example.pokemongo.repositories.IPokemonRepository
import com.example.pokemongo.util.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {

    private var database: PokemonDatabase? = null
    @Volatile
    var iPokemonRepository: IPokemonRepository? = null
        @VisibleForTesting set

    fun provideTasksRepository(context: Context): IPokemonRepository {
        synchronized(this) {
            return iPokemonRepository ?: createTasksRepository(context)
        }
    }

    private fun createTasksRepository(context: Context): IPokemonRepository {
        /*val database = database ?: createDataBase(context)*/
        val newRepo = DefaultPokemonRepository(/*database.pokemonDao(),*/ providePokemonService(context))
        iPokemonRepository = newRepo
        return newRepo
    }

    private fun provideOkHTTPClient(context: Context): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(AccessTokenInterceptor(TokenProvider(context, provideTokenService())))
            .authenticator(AccessTokenAuthenticator(TokenProvider(context, provideTokenService())))
            .build()
    }

    private fun provideTokenService(): TokenService {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TokenService::class.java)
    }

    private fun providePokemonService(context: Context): PokemonService {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(provideOkHTTPClient(context))
            .build()
            .create(PokemonService::class.java)
    }

    private fun createDataBase(context: Context): PokemonDatabase {
        val result = Room.databaseBuilder(
            context.applicationContext,
            PokemonDatabase::class.java, DATABASE_NAME
        ).build()
        database = result
        return result
    }
}
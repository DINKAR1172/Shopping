package com.example.my_app.Model.DI

import com.example.my_app.Model.REPO.FirebaseAuthRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun providesAuthInstance():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providefirestore():FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }
    @Provides
    @Singleton
    fun ProvideRetrofitInstamce(Auth: FirebaseAuth,store:FirebaseFirestore):FirebaseAuthRepo{
        return FirebaseAuthRepo(auth =Auth,store)
    }
}
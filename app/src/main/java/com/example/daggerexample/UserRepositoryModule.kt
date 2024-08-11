package com.example.daggerexample

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//@Module
//class UserRepositoryModule {
////    @Provides
////    fun getUserFireBaseRepository() : UserRepositoryService{
////        return FirebaseRepository()
////    }
//
//    // or
//
//    @Provides
//    fun getSQLRepository(sqlRepository: SQLRepository) : UserRepositoryService{
//        return sqlRepository
//    }
//
//}

// or
@Module
abstract class UserRepositoryModule {
    @Binds
    //@Singleton
    @ApplicationScope
    abstract fun getSQLRepository(sqlRepository: SQLRepository) : UserRepositoryService
}
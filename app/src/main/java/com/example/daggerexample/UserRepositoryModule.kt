package com.example.daggerexample

import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {
//    @Provides
//    fun getUserFireBaseRepository() : UserRepositoryService{
//        return FirebaseRepository()
//    }

    // or

    @Provides
    fun getSQLRepository(sqlRepository: SQLRepository) : UserRepositoryService{
        return sqlRepository
    }

}
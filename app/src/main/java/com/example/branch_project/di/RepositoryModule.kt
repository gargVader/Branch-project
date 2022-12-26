package com.example.branch_project.di

import com.example.branch_project.data.repository.BranchRepositoryImpl
import com.example.branch_project.domain.repository.BranchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBranchRepository(
        branchRepositoryImpl: BranchRepositoryImpl
    ): BranchRepository
}
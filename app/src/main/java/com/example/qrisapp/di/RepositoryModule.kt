package com.example.qrisapp.di

import com.example.qrisapp.data.repo.QRRepoImpl
import com.example.qrisapp.domain.repo.QRRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindQRRepo(
        qrRepoImpl: QRRepoImpl
    ):QRRepo
}
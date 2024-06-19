package com.example.stylosense.dependency_injection

import com.example.stylosense.items.DemoItem
import com.example.stylosense.items.ProductRepositoryImp
import com.example.stylosense.presentations.items.TaylorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ModuleData {
    @Provides
    @Singleton
    fun provideProductRepository(demoItem: DemoItem): TaylorRepository {
        return ProductRepositoryImp(demoItem)
    }

}
## Keep all the models used in your app
#-keepclassmembers class app.ditsdev.core.** {
#    private <fields>;
#    public <fields>;
#    private <methods>;
#    public <methods>;
#}
#
#
## Keep all your models (Add these at the top)
#-keep class app.ditsdev.core.data.source.remote.network.responses.** { *; }
#-keep class app.ditsdev.core.domain.model.** { *; }
#-keep class app.ditsdev.core.data.source.local.entity.** { *; }
#
## Keep all classes that have @Entity annotation
#-keep class * extends androidx.room.RoomDatabase { *; }
#-keep @androidx.room.Entity class *
#-keepclassmembers class * {
#    @androidx.room.Query *;
#    @androidx.room.Insert *;
#    @androidx.room.Update *;
#    @androidx.room.Delete *;
#}
#
## Gson specific rules (enhanced)
#-keepattributes Signature
#-keepattributes *Annotation*
#-dontwarn sun.misc.**
#-keep class * extends com.google.gson.TypeAdapter
#-keep class * implements com.google.gson.TypeAdapterFactory
#-keep class * implements com.google.gson.JsonSerializer
#-keep class * implements com.google.gson.JsonDeserializer
#-keepclassmembers,allowobfuscation class * {
#    @com.google.gson.annotations.SerializedName <fields>;
#}
## Keep any classes that will be serialized/deserialized with Gson
#-keep class app.ditsdev.core.** { *; }
#
## Retrofit (enhanced)
#-keepattributes Signature, InnerClasses, EnclosingMethod
#-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
#-keepclassmembers,allowshrinking,allowobfuscation interface * {
#    @retrofit2.http.* <methods>;
#}
#-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
#-dontwarn javax.annotation.**
#-dontwarn kotlin.Unit
#-dontwarn retrofit2.KotlinExtensions
#-dontwarn retrofit2.KotlinExtensions$*
#-if interface * { @retrofit2.http.* <methods>; }
#-keep,allowobfuscation interface <1>
#-keep class retrofit2.** { *; }
#
## RxJava (enhanced)
#-dontwarn java.util.concurrent.Flow*
#-dontwarn io.reactivex.**
#-keep class io.reactivex.** { *; }
#-keepclassmembers class io.reactivex.** { *; }
#-keepclassmembers class * {
#    @io.reactivex.annotations.* <methods>;
#}
#
## OkHttp
#-keepattributes Signature
#-keepattributes *Annotation*
#-keep class okhttp3.** { *; }
#-keep interface okhttp3.** { *; }
#-dontwarn okhttp3.**
#-dontwarn okio.**
#-keep class okio.** { *; }
#
## Keep your API interfaces
#-keep interface app.ditsdev.core.data.source.remote.network.ApiService { *; }
#
## LiveData and ViewModel
#-keep class * extends androidx.lifecycle.ViewModel {
#    <init>();
#}
#-keep class * extends androidx.lifecycle.AndroidViewModel {
#    <init>(android.app.Application);
#}
#-keep class androidx.lifecycle.** { *; }
#-keep class * extends androidx.lifecycle.LiveData { *; }
#
## Koin
#-keep class org.koin.** { *; }
#-keep public class * extends org.koin.core.module.Module { *; }
#-keepnames class * { @org.koin.core.annotation.KoinInternalApi *; }
#-keepclassmembers class * { @org.koin.core.annotation.KoinInternalApi *; }
#
## ViewBinding
#-keep class * implements androidx.viewbinding.ViewBinding {
#    public static *** bind(android.view.View);
#    public static *** inflate(android.view.LayoutInflater);
#}
#
## Keep all the models used in your app
#-keepclassmembers class app.ditsdev.core.** {
#    private <fields>;
#    public <fields>;
#    private <methods>;
#    public <methods>;
#}
#
## Keep your Repository implementations
#-keep class app.ditsdev.core.domain.repository.** { *; }
#-keep class app.ditsdev.core.data.** { *; }
#
## Preserve all annotations
#-keepattributes *Annotation*
#
## Keep Enum
#-keepclassmembers enum * { *; }
#
#
## Keep all classes and members in the core package
#-keepclasseswithmembers class app.ditsdev.core.data.resources.NetworkBoundResources {
#    *;
#}
#
## API response classes
#-keepclasseswithmembers class app.ditsdev.core.data.result.api.ApiResponseResult {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.result.resource.ResourceResult {
#    *;
#}
#
## DAO classes
#-keepclasseswithmembers class app.ditsdev.core.data.source.local.dao.GameDao {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.source.local.dao.PublisherDao {
#    *;
#}
#
## Database
#-keepclasseswithmembers class app.ditsdev.core.data.source.local.database.GameDatabase {
#    *;
#}
#
## Entities
#-keepclasseswithmembers class app.ditsdev.core.data.source.local.entity.GameEntity {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.source.local.entity.PublisherEntity {
#    *;
#}
#
## Data sources
#-keepclasseswithmembers class app.ditsdev.core.data.source.local.LocalGameDataSource {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.source.local.LocalPublisherDataSource {
#    *;
#}
#
## Network responses
#-keepclasseswithmembers class app.ditsdev.core.data.source.remote.network.responses.GameResponse {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.source.remote.network.responses.PublisherResponse {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.source.remote.network.ApiService {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.source.remote.RemoteGameDataSource {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.source.remote.RemotePublisherDataSource {
#    *;
#}
#
## Repositories
#-keepclasseswithmembers class app.ditsdev.core.data.GameRepository {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.data.PublisherRepository {
#    *;
#}
#
## DI
#-keepclasseswithmembers class app.ditsdev.core.di.CoreModule {
#    *;
#}
#
## Domain layer
#-keepclasseswithmembers class app.ditsdev.core.domain.interactor.PublisherInteractor {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.domain.interactor.GameInteractor {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.domain.model.Game {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.domain.model.Publisher {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.domain.repository.game.ImplGameRepository {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.domain.repository.publisher.ImplPublisherRepository {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.domain.usecase.GameUseCase {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.domain.usecase.PublisherUseCase {
#    *;
#}
#
## Utils
#-keepclasseswithmembers class app.ditsdev.core.utils.DataMapper {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.utils.AppExecutor {
#    *;
#}
#
#-keepclasseswithmembers class app.ditsdev.core.utils.DummyData {
#    *;
#}
#
###---------------Begin: proguard configuration for Room and SQLite ----------
#-keep class androidx.room.** { *; }
#-dontwarn androidx.room.**
#-keep class androidx.sqlite.db.** { *; }
#-dontwarn androidx.sqlite.db.**
#
#
###---------------Begin: proguard configuration for SQLCipher ----------
#-keep,includedescriptorclasses class net.sqlcipher.** { *; }
#-keep,includedescriptorclasses interface net.sqlcipher.** { *; }
#-dontwarn net.sqlcipher.**
#-keep class net.sqlcipher.** { *; }
#-dontwarn org.conscrypt.**
#-keep class org.conscrypt.** { *; }
#
###---------------Begin: proguard configuration for Gson ----------
#-keepattributes Signature
#-keepattributes *Annotation*
#-dontwarn sun.misc.**
#-keep class com.google.gson.examples.android.model.** { <fields>; }
#-keep class * extends com.google.gson.TypeAdapter
#-keep class * implements com.google.gson.TypeAdapterFactory
#-keep class * implements com.google.gson.JsonSerializer
#-keep class * implements com.google.gson.JsonDeserializer
#-keepclassmembers,allowobfuscation class * {
#    @com.google.gson.annotations.SerializedName <fields>;
#}
#
###---------------Begin: proguard configuration for Retrofit ----------
#-keepattributes Signature, InnerClasses, EnclosingMethod
#-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
#-keepclassmembers,allowshrinking,allowobfuscation interface * {
#    @retrofit2.http.* <methods>;
#}
#-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
#-dontwarn javax.annotation.**
#-dontwarn kotlin.Unit
#-dontwarn retrofit2.KotlinExtensions
#-dontwarn retrofit2.KotlinExtensions$*
#-if interface * { @retrofit2.http.* <methods>; }
#-keep,allowobfuscation interface <1>
#
###---------------Begin: proguard configuration for OkHttp ----------
#-keepattributes Signature
#-keepattributes *Annotation*
#-keep class okhttp3.** { *; }
#-keep interface okhttp3.** { *; }
#-dontwarn okhttp3.**
#-dontwarn okio.**
#
###---------------Begin: proguard configuration for RxJava ----------
#-dontwarn java.util.concurrent.Flow*
#-dontwarn io.reactivex.**
#-keep class io.reactivex.** { *; }
#-keepclassmembers class io.reactivex.** { *; }
#
###---------------Begin: proguard configuration for Koin ----------
#-keep class org.koin.** { *; }
#-dontwarn org.koin.**
#-keep class org.koin.core.annotation.** { *; }
#-keepclassmembers class * {
#    @org.koin.core.annotation.KoinInternalApi *;
#}
#-keepnames class * extends org.koin.core.component.KoinComponent
#-keepnames class * extends org.koin.core.module.Module
#
###---------------Begin: proguard configuration for LiveData ----------
#-keepclassmembers class * extends androidx.lifecycle.ViewModel {
#    <init>(...);
#}
#-keepclassmembers class * extends androidx.lifecycle.AndroidViewModel {
#    <init>(...);
#}
#-keep class * extends androidx.lifecycle.LiveData { *; }
#-keep class * extends androidx.lifecycle.ViewModel { *; }
#
###---------------Begin: proguard configuration for ViewBinding ----------
#-keep class * implements androidx.viewbinding.ViewBinding {
#    public static *** bind(android.view.View);
#    public static *** inflate(android.view.LayoutInflater);
#}
#
###---------------Begin: proguard configuration for Coil ----------
#-keep class coil.** { *; }
#-keep interface coil.** { *; }
#-dontwarn coil.**
#-keepclassmembers class * {
#    @coil.annotation.* <methods>;
#}
#
## Keep your model classes (if not already covered by Gson rules)
#-keep class your.package.name.models.** { *; }
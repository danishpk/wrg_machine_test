
import com.whiterabbit.machinetest.data.api.EmployeeApi
import com.whiterabbit.machinetest.data.api.OkHttpClientFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private const val BASE_URL = "http://www.mocky.io/v2/"

    private val client by lazy { OkHttpClientFactory.createClient() }

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .client(client)
            .baseUrl(BASE_URL)
            .build()
    }
    val EMPLOYEE_API_API: EmployeeApi by lazy { retrofit.create(EmployeeApi::class.java) }

}
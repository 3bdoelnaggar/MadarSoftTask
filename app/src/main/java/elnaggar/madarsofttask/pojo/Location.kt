package elnaggar.madarsofttask.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "location")
data class Location(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val address: String,
    val latitude: Double,
    val longitude: Double

):Serializable
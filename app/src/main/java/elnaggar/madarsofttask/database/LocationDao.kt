package elnaggar.madarsofttask.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import elnaggar.madarsofttask.pojo.Location

@Dao
interface LocationDao {
    @Insert
    fun insert(location: Location): Long

    @Query("Select * from location")
    fun readAll(): List<Location>
}
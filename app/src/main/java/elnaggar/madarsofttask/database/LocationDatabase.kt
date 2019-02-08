package elnaggar.madarsofttask.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import elnaggar.madarsofttask.pojo.Location


@Database(entities = arrayOf(Location::class), version = 1, exportSchema = false)
abstract class LocationDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao

    companion object {
        private var INSTANCE: LocationDatabase? = null
        fun getInstance(context: Context): LocationDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    LocationDatabase::class.java,
                    "locationdb"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE as LocationDatabase
        }
    }
}
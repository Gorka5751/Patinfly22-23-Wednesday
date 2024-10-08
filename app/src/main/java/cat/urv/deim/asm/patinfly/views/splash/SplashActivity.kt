package cat.urv.deim.asm.patinfly.views.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R

import cat.urv.deim.asm.patinfly.base.AppConfig.Companion.DEFAULT_SCOOTER_RAW_JSON_FILE

import cat.urv.deim.asm.patinfly.models.ScooterRepository
import cat.urv.deim.asm.patinfly.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.persistence.ScooterDao
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.utils.postDelayed
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.apiREST.OKListener
import cat.urv.deim.asm.patinfly.views.scooter.ScootersListActivity


//NOM DELS INTEGRANTS DEL GRUP: GORKA ZAMORANO ORÓ I POL CULLERÉ FARRÉ
// GRUP DE ASM --> ASM25

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        //ESTE TROZO COMENTADO ES PARA INTRODUCIR LOS DATOS DEL JSON LOCAL EN LA BASE DE DATOS
        //EN LA PRACTICA 3 YA IMPLEMENTAMOS LOS GET A TRAVES DE UNA URL PARA ACCEDER AL JSON.

        /*val scooters : List<Scooter> = ScooterRepository.activeScooterList(this,DEFAULT_SCOOTER_RAW_JSON_FILE)


        //Insertem els scooters del JSON a la base de dades just al obrir la app.
        for (scooter in scooters){
           ScooterRepository.insertArrayScooters(scooterDao,scooter)
        }*/

        //Hace una peticion http al servidor y devuelve un fichero JSON que lo
        // añade a la base de datos local ROOM.
        val db = AppDatabase.getInstance(this)
        val scooterDao: ScooterDao = db.ScooterDao()
        ScooterRepository.deleteAllScooters(this,scooterDao)
        OKListener().onResponse(this)



        postDelayed(3000){
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
    }


}

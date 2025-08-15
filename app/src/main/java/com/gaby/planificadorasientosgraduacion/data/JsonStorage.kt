package com.gaby.planificadorasientosgraduacion.data

import android.content.Context
import com.gaby.planificadorasientosgraduacion.model.Asiento
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

object JsonStorage {

    private const val FILE_NAME = "asientos.json"

    fun guardarAsientos(context: Context, asientos: List<Asiento>) {
        val gson = Gson()
        val jsonString = gson.toJson(asientos)
        val file = File(context.filesDir, FILE_NAME)
        file.writeText(jsonString)
    }

    fun cargarAsientos(context: Context): List<Asiento> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return emptyList()

        val jsonString = file.readText()
        val gson = Gson()
        val tipoLista = object : TypeToken<List<Asiento>>() {}.type
        return gson.fromJson(jsonString, tipoLista)
    }
}

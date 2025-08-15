package com.gaby.planificadorasientosgraduacion.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaby.planificadorasientosgraduacion.model.Asiento
import com.gaby.planificadorasientosgraduacion.data.Estudiante
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.io.File

class PlanificadorViewModel : ViewModel() {

    private val gson = Gson()
    private val nombreArchivoAsientos = "asientos_guardados.json"
    private val nombreArchivoEstudiantes = "estudiantes_guardados.json"
    private var yaInicializado = false
    private val _cargando = mutableStateOf(true)
    private val _listadoAsientos = mutableStateListOf<Asiento>()
    val listadoAsientos: SnapshotStateList<Asiento> get() = _listadoAsientos

    private val _listadoEstudiantes = mutableStateListOf<Estudiante>()

    val listadoEstudiantes: SnapshotStateList<Estudiante> get() = _listadoEstudiantes

    fun inicializar(context: Context) {
        if (yaInicializado) return
        yaInicializado = true
        Log.d("ViewModel", "Inicializando...")
        cargarDatosIniciales(context)
        Log.d("ViewModel", "Finalizando carga...")
        _cargando.value = false
    }

    private fun cargarDatosIniciales(context: Context) {
        cargarAsientosDesdeArchivo(context)
        cargarEstudiantesDesdeArchivo(context)
        if (_listadoAsientos.isEmpty()) precargarAsientosMock()
        if (_listadoEstudiantes.isEmpty()) precargarEstudiantesMock()
    }

    fun obtenerEstudiantePorId(id: String?): Estudiante? {
        return listadoEstudiantes.find { it.id == id }
    }


    fun actualizarEstudianteYGuardar(context: Context, estudianteEditado: Estudiante) {
        val index = _listadoEstudiantes.indexOfFirst { it.id == estudianteEditado.id }
        if (index != -1) {
            _listadoEstudiantes[index] = estudianteEditado
        } else {
            _listadoEstudiantes.add(estudianteEditado)
        }
        guardarEstudiantesEnArchivo(context)
    }


    fun guardarEstudiantesEnArchivo(context: Context) {
        viewModelScope.launch {         //corutina alternativa, sin que crashee el app /segundo plano
            try {
                val json = gson.toJson(_listadoEstudiantes)
                val archivo = File(context.filesDir, nombreArchivoEstudiantes)
                archivo.writeText(json)
            } catch (e: Exception) {
                Log.e("ViewModel", "Error al guardar estudiantes: ${e.message}")
            }
        }
    }


    fun guardarAsientosEnArchivo(context: Context) {
        try {
            val json = gson.toJson(listadoAsientos)
            val archivo = File(context.filesDir, nombreArchivoAsientos)
            archivo.writeText(json)
        } catch (e: Exception) {
            Log.e("GuardarAsientos", "Error al guardar asientos", e)
        }
    }

    fun actualizarAsiento(asientoActualizado: Asiento, context: Context) {
      /** if (asientoActualizado.codigo.isBlank()) {
            Toast.makeText(context, "Código de asiento inválido", Toast.LENGTH_SHORT).show()
            return
        }*/
        val index = listadoAsientos.indexOfFirst { it.codigo == asientoActualizado.codigo }
        if (index != -1) {
            listadoAsientos[index] = asientoActualizado
            guardarAsientosEnArchivo(context)
            Toast.makeText(context, "Asiento actualizado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Error: asiento no encontrado", Toast.LENGTH_SHORT).show()
        }
    }

    fun cargarEstudiantesDesdeArchivo(context: Context) {
        try {
            val archivo = File(context.filesDir, nombreArchivoEstudiantes)
            _listadoEstudiantes.clear()
            precargarEstudiantesMock()

            if (archivo.exists()) {
                val json = archivo.readText()
                if (json.isNotBlank()) {
                    val tipoLista = object : TypeToken<List<Estudiante>>() {}.type
                    val estudiantesDesdeArchivo: List<Estudiante> = gson.fromJson(json, tipoLista)
                    val nuevos = estudiantesDesdeArchivo.filter { archivoEst ->
                        _listadoEstudiantes.none { it.id == archivoEst.id }
                    }
                    _listadoEstudiantes.addAll(nuevos)
                }
            }
        } catch (e: Exception) {
            Log.e("ViewModel", "Error al cargar estudiantes: ${e.message}")
        }
    }

    fun cargarAsientosDesdeArchivo(context: Context) {
        try {
            val archivo = File(context.filesDir, nombreArchivoAsientos)     //instancia de File para poder leer el archivo
            Log.d("ViewModel", "Archivo asientos existe: ${archivo.exists()}")
            if (archivo.exists()) {
                val json = archivo.readText()
                val tipoLista = object : TypeToken<List<Asiento>>() {}.type
                val asientos: List<Asiento> = gson.fromJson(json, tipoLista)                //convierte el texto JSON en una lista real de objetos Kotlin
                _listadoAsientos.clear()                            //limpiamos lista para evitar duplicados
                _listadoAsientos.addAll(asientos)       //anadir elementos nuevos cargados
            }
        } catch (e: Exception) {
            Log.e("ViewModel", "Error al cargar asientos: ${e.message}")
        }
    }


    fun precargarEstudiantesMock() {
        _listadoEstudiantes.addAll(
            listOf(
                Estudiante(
                    id = "2024-0142",
                    nombre = "Laura G. Sanchez",
                    merito = "Summa Cum Laude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2022-30-3-0016",
                    nombre = "Alessandro Alcime",
                    merito = "Suma CumLaude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2022-30-3-0019",
                    nombre = "Federico B. Bencosme",
                    merito = "Cum Laude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2022-30-3-0008",
                    nombre = "Robert A. Cedeno",
                    merito = "Magna Cum Laude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2022-30-3-0053",
                    nombre = "Wellington Diaz",
                    merito = "Magna Cum Laude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2021-30-2-0005",
                    nombre = "Maximo Liberata",
                    merito = "Magna Cum Laude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2022-30-3-0050",
                    nombre = "Wordy A. Marte",
                    merito = "Cum Laude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2021-30-3-0008",
                    nombre = "Robert A. Miranda",
                    merito = "Cum Laude",
                    carrera = "Software"
                ),
                Estudiante(
                    id = "2020-30-1-0036",
                    nombre = "Fulvio A. Moya",
                    merito = "Summa Cum Laude",
                    carrera = "Educacion"
                ),
                Estudiante(
                    id = "2021-30-1-0032",
                    nombre = "Luis Alfonso",
                    merito = "Magna Cum Laude",
                    carrera = "Cibersecurity"
                ),
                Estudiante(
                    id = "2020-0123",
                    nombre = "Nicky Minaj",
                    merito = "",
                    carrera = "Administracion"
                )
            )
        )
    }

    fun precargarAsientosMock() {
        _listadoAsientos.addAll(
            listOf(
                Asiento(
                    codigo = "A1",
                    idEstudiante = "2024-0142",
                    carrera = null,
                    x = 0.61731f,
                    y = 0.12026f
                ),
                Asiento(
                    codigo = "A2",
                    idEstudiante = "2022-30-3-0016",
                    carrera = null,
                    x = 0.5862f,
                    y = 0.14234f
                ),
                Asiento(
                    codigo = "A3",
                    idEstudiante = "2022-30-3-0019",
                    carrera = null,
                    x = 0.54991f,
                    y = 0.12661f
                ),
                Asiento(
                    codigo = "A4",
                    idEstudiante = "2022-30-3-0008",
                    carrera = null,
                    x = 0.51509f,
                    y = 0.11026f
                ),
                Asiento(
                    codigo = "A5",
                    idEstudiante = "2022-30-3-0053",
                    carrera = null,
                    x = 0.58361f,
                    y = 0.10359f
                ),
                Asiento(
                    codigo = "A6",
                    idEstudiante = "2021-30-2-0005",
                    carrera = null,
                    x = 0.55037f,
                    y = 0.08677f
                ),
                Asiento(
                    codigo = "A7",
                    idEstudiante = "2022-30-3-0050",
                    carrera = null,
                    x = 0.5162f,
                    y = 0.06995f
                ),
                Asiento(
                    codigo = "A8",
                    idEstudiante = "2021-30-3-0008",
                    carrera = null,
                    x = 0.47861f,
                    y = 0.0951f
                ),
                Asiento(
                    codigo = "A9",
                    idEstudiante = "2020-30-1-0036",
                    carrera = null,
                    x = 0.48259f,
                    y = 0.05318f
                ),
                Asiento(
                    codigo = "A10",
                    idEstudiante = "2021-30-1-0032",
                    carrera = null,
                    x = 0.4488f,
                    y = 0.0363f
                ),

                // Asientos vacíos
                Asiento(
                    codigo = "A11",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.44278f,
                    y = 0.07932f
                ),
                Asiento(
                    codigo = "A12",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.40685f,
                    y = 0.06354f
                ),
                Asiento(
                    codigo = "A13",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.55769f,
                    y = 0.16495f
                ),
                Asiento(
                    codigo = "A14",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.51972f,
                    y = 0.15068f
                ),
                Asiento(
                    codigo = "A15",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.44389f,
                    y = 0.12141f
                ),
                Asiento(
                    codigo = "A16",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.40593f,
                    y = 0.10661f
                ),
                Asiento(
                    codigo = "A17",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.36806f,
                    y = 0.09208f
                ),
                Asiento(
                    codigo = "A18",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.41213f,
                    y = 0.1488f
                ),
                Asiento(
                    codigo = "A19",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.37222f,
                    y = 0.13536f
                ),
                Asiento(
                    codigo = "A20",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.33176f,
                    y = 0.12193f
                ),
                Asiento(
                    codigo = "A21",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.48185f,
                    y = 0.13604f
                ),
                Asiento(
                    codigo = "A22",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.45194f,
                    y = 0.16224f
                ),
                Asiento(
                    codigo = "A23",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.38343f,
                    y = 0.17708f
                ),
                Asiento(
                    codigo = "A24",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.34167f,
                    y = 0.16531f
                ),
                Asiento(
                    codigo = "A25",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.27102f,
                    y = 0.1849f
                ),
                Asiento(
                    codigo = "A26",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.31435f,
                    y = 0.19615f
                ),
                Asiento(
                    codigo = "A27",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.35778f,
                    y = 0.20667f
                ),
                Asiento(
                    codigo = "A28",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.3f,
                    y = 0.15276f
                ),
                Asiento(
                    codigo = "A29",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.53176f,
                    y = 0.1888f
                ),
                Asiento(
                    codigo = "A30",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.50833f,
                    y = 0.2138f
                ),
                Asiento(
                    codigo = "A31",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.48778f,
                    y = 0.2388f
                ),
                Asiento(
                    codigo = "A32",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.46963f,
                    y = 0.26531f
                ),
                Asiento(
                    codigo = "A33",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.45491f,
                    y = 0.29182f
                ),
                Asiento(
                    codigo = "A34",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.42889f,
                    y = 0.34901f
                ),
                Asiento(
                    codigo = "A35",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.41907f,
                    y = 0.37635f
                ),
                Asiento(
                    codigo = "A36",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.4112f,
                    y = 0.40365f
                ),
                Asiento(
                    codigo = "A37",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.40528f,
                    y = 0.43115f
                ),
                Asiento(
                    codigo = "A38",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.4013f,
                    y = 0.4588f
                ),
                Asiento(
                    codigo = "A39",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.39935f,
                    y = 0.48641f
                ),
                Asiento(
                    codigo = "A40",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.36009f,
                    y = 0.48594f
                ),
                Asiento(
                    codigo = "A41",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.32046f,
                    y = 0.48552f
                ),
                Asiento(
                    codigo = "A42",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.28102f,
                    y = 0.48505f
                ),
                Asiento(
                    codigo = "A43",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.24157f,
                    y = 0.48417f
                ),
                Asiento(
                    codigo = "A44",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.20213f,
                    y = 0.4837f
                ),
                Asiento(
                    codigo = "A45",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.16028f,
                    y = 0.48417f
                ),
                Asiento(
                    codigo = "A46",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.16259f,
                    y = 0.45031f
                ),
                Asiento(
                    codigo = "A47",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.20426f,
                    y = 0.4524f
                ),
                Asiento(
                    codigo = "A48",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.24407f,
                    y = 0.45344f
                ),

                Asiento(
                    codigo = "B1",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.28296f,
                    y = 0.455f
                ),
                Asiento(
                    codigo = "B2",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.32278f,
                    y = 0.45604f
                ),
                Asiento(
                    codigo = "B3",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.36167f,
                    y = 0.4576f
                ),
                Asiento(
                    codigo = "B4",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.36537f,
                    y = 0.42896f
                ),
                Asiento(
                    codigo = "B5",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.32648f,
                    y = 0.42688f
                ),
                Asiento(
                    codigo = "B6",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.28759f,
                    y = 0.42427f
                ),
                Asiento(
                    codigo = "B7",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.24778f,
                    y = 0.42219f
                ),
                Asiento(
                    codigo = "B8",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.20889f,
                    y = 0.4201f
                ),
                Asiento(
                    codigo = "B9",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.1663f,
                    y = 0.41698f
                ),
                Asiento(
                    codigo = "B10",
                    idEstudiante = null,
                    carrera = null,
                    x = 0.39935f,
                    y = 0.51406f
                ),
                Asiento("B11", null, null, 0.36f, 0.51448f),
                Asiento("B12", null, null, 0.32046f, 0.51495f),
                Asiento("B13", null, null, 0.28102f, 0.51583f),
                Asiento("B14", null, null, 0.24157f, 0.51625f),
                Asiento("B15", null, null, 0.20213f, 0.51677f),
                Asiento("B16", null, null, 0.16028f, 0.51625f),
                Asiento("B17", null, null, 0.4013f, 0.54167f),
                Asiento("B18", null, null, 0.36194f, 0.54302f),
                Asiento("B19", null, null, 0.3225f, 0.54432f),
                Asiento("B20", null, null, 0.28315f, 0.54568f),
                Asiento("B21", null, null, 0.2438f, 0.54698f),
                Asiento("B22", null, null, 0.20444f, 0.54833f),
                Asiento("B23", null, null, 0.16259f, 0.54974f),
                Asiento("B24", null, null, 0.40528f, 0.56922f),
                Asiento("B25", null, null, 0.4112f, 0.59677f),
                Asiento("B26", null, null, 0.37148f, 0.5999f),
                Asiento("B27", null, null, 0.36602f, 0.57151f),
                Asiento("B28", null, null, 0.33306f, 0.60292f),
                Asiento("B29", null, null, 0.32676f, 0.5737f),
                Asiento("B30", null, null, 0.29398f, 0.60604f),
                Asiento("B31", null, null, 0.28676f, 0.57594f),
                Asiento("B32", null, null, 0.25491f, 0.60917f),
                Asiento("B33", null, null, 0.24787f, 0.57812f),
                Asiento("B34", null, null, 0.21583f, 0.61224f),
                Asiento("B35", null, null, 0.20787f, 0.58036f),
                Asiento("B36", null, null, 0.1663f, 0.58276f),
                Asiento("B37", null, null, 0.17444f, 0.61562f),
                Asiento("B38", null, null, 0.41907f, 0.62417f),
                Asiento("B39", null, null, 0.4287f, 0.65104f),
                Asiento("B40", null, null, 0.39093f, 0.65609f),
                Asiento("B41", null, null, 0.38019f, 0.62771f),
                Asiento("B42", null, null, 0.34102f, 0.63208f),
                Asiento("B43", null, null, 0.30287f, 0.63604f),
                Asiento("B44", null, null, 0.26361f, 0.64005f),
                Asiento("B45", null, null, 0.22454f, 0.64401f),
                Asiento("B46", null, null, 0.18296f, 0.64823f),
                Asiento("B47", null, null, 0.35204f, 0.66078f),
                Asiento("B48", null, null, 0.31324f, 0.66599f),
                Asiento("B49", null, null, 0.27491f, 0.67089f),
                Asiento("B50", null, null, 0.23639f, 0.67536f),
                Asiento("B51", null, null, 0.19556f, 0.68089f),
                Asiento("B52", null, null, 0.39037f, 0.34417f),
                Asiento("B53", null, null, 0.37213f, 0.40052f),
                Asiento("B54", null, null, 0.37972f, 0.37276f),
                Asiento("B55", null, null, 0.34139f, 0.36807f),
                Asiento("B56", null, null, 0.30222f, 0.36422f),
                Asiento("B57", null, null, 0.29398f, 0.39427f),
                Asiento("B58", null, null, 0.25444f, 0.39125f),
                Asiento("B59", null, null, 0.21583f, 0.38812f),
                Asiento("B60", null, null, 0.17444f, 0.38484f),
                Asiento("B61", null, null, 0.18296f, 0.35187f),
                Asiento("B62", null, null, 0.225f, 0.35635f),
                Asiento("B63", null, null, 0.26361f, 0.36031f),
                Asiento("B64", null, null, 0.3325f, 0.3975f),
                Asiento("B65", null, null, 0.35157f, 0.33932f),
                Asiento("B66", null, null, 0.31343f, 0.33443f),
                Asiento("B67", null, null, 0.27491f, 0.32958f),
                Asiento("B68", null, null, 0.23639f, 0.32474f),
                Asiento("B69", null, null, 0.19556f, 0.31958f),
                Asiento("B70", null, null, 0.40861f, 0.28333f),
                Asiento("B71", null, null, 0.425f, 0.25516f),
                Asiento("B72", null, null, 0.44481f, 0.22786f),
                Asiento("B73", null, null, 0.46667f, 0.20161f),
                Asiento("B74", null, null, 0.49241f, 0.17573f),
                Asiento("B75", null, null, 0.42491f, 0.18984f),
                Asiento("B76", null, null, 0.40111f, 0.2175f),
                Asiento("B77", null, null, 0.38019f, 0.24635f),
                Asiento("B78", null, null, 0.33528f, 0.23625f),
                Asiento("B79", null, null, 0.29037f, 0.22745f),
                Asiento("B80", null, null, 0.24556f, 0.21797f),
                Asiento("B81", null, null, 0.22269f, 0.25234f),
                Asiento("B82", null, null, 0.27009f, 0.2599f),
                Asiento("B83", null, null, 0.31519f, 0.26797f),
                Asiento("B84", null, null, 0.36241f, 0.27599f),

                Asiento("C1", "2020-0123", null, 0.5862f, 0.85703f),
                Asiento("C2", null, null, 0.54991f, 0.87281f),
                Asiento("C3", null, null, 0.51509f, 0.88917f),
                Asiento("C4", null, null, 0.58361f, 0.89583f),
                Asiento("C5", null, null, 0.55037f, 0.9126f),
                Asiento("C6", null, null, 0.5162f, 0.92943f),
                Asiento("C7", null, null, 0.47861f, 0.90432f),
                Asiento("C8", null, null, 0.48259f, 0.94625f),
                Asiento("C9", null, null, 0.4488f, 0.96307f),
                Asiento("C10", null, null, 0.44278f, 0.92005f),
                Asiento("C11", null, null, 0.40685f, 0.93583f),
                Asiento("C12", null, null, 0.55769f, 0.83443f),
                Asiento("C13", null, null, 0.51972f, 0.84875f),
                Asiento("C14", null, null, 0.44389f, 0.87802f),
                Asiento("C15", null, null, 0.40593f, 0.89276f),
                Asiento("C16", null, null, 0.36806f, 0.90729f),
                Asiento("C17", null, null, 0.41213f, 0.85057f),
                Asiento("C18", null, null, 0.37222f, 0.86401f),
                Asiento("C19", null, null, 0.33176f, 0.87745f),
                Asiento("C20", null, null, 0.48185f, 0.86339f),
                Asiento("C21", null, null, 0.45194f, 0.83714f),
                Asiento("C22", null, null, 0.38343f, 0.82229f),
                Asiento("C23", null, null, 0.34167f, 0.83406f),
                Asiento("C24", null, null, 0.27102f, 0.81448f),
                Asiento("C25", null, null, 0.31435f, 0.80323f),
                Asiento("C26", null, null, 0.35778f, 0.79276f),
                Asiento("C27", null, null, 0.3f, 0.84661f),
                Asiento("C28", null, null, 0.53176f, 0.81063f),
                Asiento("C29", null, null, 0.50833f, 0.78557f),
                Asiento("C30", null, null, 0.48778f, 0.76057f),
                Asiento("C31", null, null, 0.46963f, 0.73406f),
                Asiento("C32", null, null, 0.45491f, 0.7076f),
                Asiento("C33", null, null, 0.40861f, 0.71609f),
                Asiento("C34", null, null, 0.425f, 0.74422f),
                Asiento("C35", null, null, 0.44481f, 0.77151f),
                Asiento("C36", null, null, 0.46667f, 0.79776f),
                Asiento("C37", null, null, 0.49241f, 0.8237f),
                Asiento("C38", null, null, 0.42491f, 0.80953f),
                Asiento("C39", null, null, 0.40111f, 0.78187f),
                Asiento("C40", null, null, 0.38019f, 0.75302f),
                Asiento("C41", null, null, 0.33528f, 0.76313f),
                Asiento("C42", null, null, 0.29046f, 0.77198f),
                Asiento("C43", null, null, 0.24556f, 0.78146f),
                Asiento("C44", null, null, 0.22269f, 0.74708f),
                Asiento("C45", null, null, 0.27009f, 0.73948f),
                Asiento("C46", null, null, 0.31519f, 0.73146f),
                Asiento("C47", null, null, 0.36241f, 0.72344f)
            )
        )
    }

}

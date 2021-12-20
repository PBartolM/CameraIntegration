package com.example.cameraintegration



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.cameraintegration.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //carga la imagen que se le indica
        val loadImage=registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.imageView.setImageURI(it)
            })
        //lanza el sistema de fichero de Android
        binding.btnLoadImage.setOnClickListener(View.OnClickListener {
            loadImage.launch("image/*")
        })
        //sitema antiguo
        val boton1=findViewById<Button>(R.id.boton1)
        //lanza la segunda pantalla (activity)
        boton1.setOnClickListener {
            val intento1 = Intent(this, AccesoCamara::class.java)
            startActivity(intento1)
        }
    }
}
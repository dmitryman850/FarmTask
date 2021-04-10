package dmitry.man.farmapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), StartFragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container_activity_main, StartFragment.newInstance())
            .commit()
    }

    override fun save() {
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }
}
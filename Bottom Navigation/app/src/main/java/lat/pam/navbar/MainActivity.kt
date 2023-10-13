package lat.pam.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import lat.pam.navbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Following())
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.following -> {replaceFragment(Following())
                    // Respond to navigation following click
                    true
                }
                R.id.discover -> {replaceFragment(Discover())
                    // Respond to navigation discover click
                    true
                }
                R.id.browse -> {replaceFragment(Browse())
                    // Respond to navigation browse click
                    true
                }
                R.id.search -> {replaceFragment(Search())
                    // Respond to navigation search click
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }
}

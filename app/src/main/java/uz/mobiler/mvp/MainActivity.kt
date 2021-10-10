package uz.mobiler.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.mobiler.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contract.View {

    var presenter: Presenter? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this, Model())
        binding.button.setOnClickListener { presenter?.onButtonClick() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
        binding.textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
        binding.textView.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        binding.textView.text = string
    }
}
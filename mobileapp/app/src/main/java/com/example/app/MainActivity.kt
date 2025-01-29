class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fileAdapter = FileAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSearch()
        setupFileList()
        setupUploadButton()
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { filterFiles(it) }
                return true
            }
        })
    }

    private fun filterFiles(query: String) {
        val filtered = fileList.filter { it.name.contains(query, true) }
        fileAdapter.updateList(filtered)
    }
}
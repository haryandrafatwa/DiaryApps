package motion.diaryapps.list_notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import motion.diaryapps.R;
import motion.diaryapps.create_notes.CreateNotesActivity;
import motion.diaryapps.utils.Tools;

/**
 * Activity Untuk Menampilkan List Notes yang ada
 */
public class ListNotesActivity extends AppCompatActivity {

    private List<ListNotesModel> mLists = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * Method ini digunakan untuk menjalankan aksi ketika activity dibuat
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        initToolbar();

        // TODO: 4/12/19 panggil initRecyclerView() disini
        initRecyclerView();
        // TODO: 4/12/19 panggil initDummy() disini
        initDummy();
    }

    /**
     * method ini digunakan untuk membuat toolbar
     */
    public void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Diary Apps");
    }

    /**
     * Method ini digunakan untuk membuat recyclerview.
     */
    public void initRecyclerView() {
        // TODO: 4/12/19 -> ganti null dengan component RecyclerView pada activity_list_notes
        // hint: gunakan findViewById(R.id.xxxxx);
        mRecyclerView = findViewById(R.id.rvListNotes);

        // TODO: 4/12/19 -> ganti null dengan objek ListNotesAdapter
        mAdapter = new ListNotesAdapter(mLists,this);

        // TODO: 4/12/19 -> ganti null dengan objek LinearLayoutManager
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Method ini digunakan untuk membuat data dummy pada list
     */
    public void initDummy() {
        // TODO: 4/12/19 -> lengkapi parameter untuk ListNotesModel disini
        // hint: lakukan setelah menambahkan constructor pada ListNotesModel
        // untuk date gunakan Tools.getCurrentDateISO8601()

        mLists.add(new ListNotesModel("1","https://t-ec.bstatic.com/images/hotel/max1024x768/136/136201154.jpg","Paradise Lost",Tools.getCurrentDateISO8601()));
        mLists.add(new ListNotesModel("2","https://t-ec.bstatic.com/images/hotel/max1024x768/136/136201154.jpg","Paradise Lost",Tools.getCurrentDateISO8601()));
        mLists.add(new ListNotesModel("3","https://t-ec.bstatic.com/images/hotel/max1024x768/136/136201154.jpg","Paradise Lost",Tools.getCurrentDateISO8601()));
        mAdapter.notifyDataSetChanged();
    }


    /**
     * Method ini digunakan untuk menambahkan options menu dengan men-inflate
     * layout menu pada {@code R.menu.menu_list_notes} ke {@code menu}
     *
     * @param menu menu bawaan pada toolbar
     * @return true - mengganti menu bawaan
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_notes, menu);
        return true;
    }

    /**
     * method ini digunakan untuk mengatur ketika item pada menu di klik
     *
     * @param item MenuItem Bawaan
     * @return jika item yang di klik merupakan menuAdd maka panggil
     * method {@code startActivity(context)} pada class {@link CreateNotesActivity}
     *
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuAdd) {
            CreateNotesActivity.startActivity(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

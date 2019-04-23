package motion.diaryapps.list_notes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import motion.diaryapps.R;
import motion.diaryapps.detail_notes.DetailNotesActivity;
import motion.diaryapps.utils.Tools;

/**
 * Class ini digunakan sebagai Adapter dari recycler view
 */
public class ListNotesAdapter extends RecyclerView.Adapter<ListNotesAdapter.ViewHolder> {

    private List<ListNotesModel> mLists = new ArrayList<>();
    private Context mContext;
    // TODO: 4/12/19 -> Tambahkan Constructor disini
    // hint: gunakan alt+insert

    public ListNotesAdapter(List<ListNotesModel> mLists, Context mContext) {
        this.mLists = mLists;
        this.mContext = mContext;
    }

    /**
     * Method ini digunakan untuk membuat ViewHolder dari item yang akan diulang
     * @param viewGroup parent view
     * @param i position
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();

        // TODO: 4/12/19 -> ganti null dengan LayoutInflater.from(...).inflate(...)
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_notes,viewGroup,false);

        // TODO: 4/12/19 -> ganti null dengan Inisialisasi objek ViewHolder disini dengan memasukkan view yang telah dibuat
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    /**
     * Method ini digunakan untuk memasang data pada viewHolder,
     * method ini juga dipanggil setiap kali menggunakan {@code Adapter.notifyDataSetChanged()}
     * @param viewHolder view dari item
     * @param i position item
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final int position = i;

        // TODO: 4/12/19 -> set setiap component yang akan tampil sesuai dengan data pada mList
        // hint: untuk date gunakan Tools.getNormalDate(....)
        final ListNotesModel list = mLists.get(i);
        viewHolder.tvItemListNotesTitle.setText(list.getTitle());
        viewHolder.tvItemListNotesDate.setText(list.getDate());

        viewHolder.cvItemListNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: 4/12/19 -> ganti null dengan objek Intent baru ke DetailNotesActivity disini
                // hint: gunakan mContext untuk mengisi parameter context
                Intent intent = new Intent(mContext,DetailNotesActivity.class);

                mContext.startActivity(intent);
            }
        });

        Tools.setImage(viewHolder.ivItemListNotes,mLists.get(position).getImage_url());
    }

    /**
     * method ini digunakan untuk menampilkan jumlah item yang akan tampil
     * @return list size
     */
    @Override
    public int getItemCount() {
        // TODO: 4/12/19 -> ganti return menjadi panjang list
        // hint : gunakan method xxxx.size()
        return mLists.size();
    }

    /**
     * Class ini digunakan sebagai Holder dari item view.
     * Class ini dapat di isi dengan attribute dan method yang akan digunakan.
     * Class ini dipanggil hanya di panggil 1x melalui onCreateViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cvItemListNotes;
        ImageView ivItemListNotes;

        // TODO: 4/12/19  -> buat attribute setiap component disini
        // hint: ikuti contoh diatas
        TextView tvItemListNotesDate;
        TextView tvItemListNotesTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItemListNotes = itemView.findViewById(R.id.cvItemListNotes);
            ivItemListNotes = itemView.findViewById(R.id.ivItemListNotes);

            // TODO: 4/12/19 -> inisialisasi setiap attribute dengan idnya disini
            // hint: gunakan itemView.findViewById(R.id.xxxxx) seperti contoh diatas
            tvItemListNotesDate = itemView.findViewById(R.id.tvItemListNotesDate);
            tvItemListNotesTitle = itemView.findViewById(R.id.tvItemListNotesTitle);
        }
    }
}

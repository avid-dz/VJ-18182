package ba.unsa.etf.rma.VJ_18182;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PrikazDetaljaOMuzicaruActivity extends AppCompatActivity {

    private TextView textViewNazivMuzicara;
    private TextView textViewZanrMuzicara;
    private TextView textViewWebStranicaMuzicara;
    private TextView textViewBiografijaMuzicara;
    private ListView listaTop5Pjesama;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> pjesme = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalji_o_muzicaru);
        textViewNazivMuzicara = (TextView) findViewById(R.id.detaljiNazivMuzicara);
        textViewNazivMuzicara.setText(getIntent().getStringExtra("imeIPrezimeMuzicara"));
        textViewZanrMuzicara = (TextView) findViewById(R.id.detaljiZanrMuzicara);
        textViewZanrMuzicara.setText(getIntent().getStringExtra("zanrMuzicara"));
        textViewWebStranicaMuzicara = (TextView) findViewById(R.id.detaljiWebStranicaMuzicara);
        textViewWebStranicaMuzicara.setText(getIntent().getStringExtra("webStranicaMuzicara"));
        textViewBiografijaMuzicara = (TextView) findViewById(R.id.detaljiBiografijaMuzicara);
        textViewBiografijaMuzicara.setText(getIntent().getStringExtra("biografijaMuzicara"));
        listaTop5Pjesama = (ListView) findViewById(R.id.detaljiTop5PjesamaMuzicara);
        pjesme = getIntent().getStringArrayListExtra("top5PjesamaMuzicara");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pjesme);
        listaTop5Pjesama.setAdapter(adapter);
        postaviListenerNaLink();
    }

    private void postaviListenerNaLink() {
        textViewWebStranicaMuzicara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getIntent().getStringExtra("webStranicaMuzicara")));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });
    }
}

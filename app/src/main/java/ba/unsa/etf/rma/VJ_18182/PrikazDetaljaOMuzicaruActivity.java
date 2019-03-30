package ba.unsa.etf.rma.VJ_18182;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PrikazDetaljaOMuzicaruActivity extends AppCompatActivity {

    private TextView textViewNazivMuzicara;
    private TextView textViewZanrMuzicara;
    private TextView textViewWebStranicaMuzicara;
    private TextView textViewBiografijaMuzicara;
    private ListView listaTop5Pjesama;
    private Button dugmePodijeliBiografiju;
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
        dugmePodijeliBiografiju = (Button) findViewById(R.id.detaljiPodijeliBiografiju);
        listaTop5Pjesama = (ListView) findViewById(R.id.detaljiTop5PjesamaMuzicara);
        pjesme = getIntent().getStringArrayListExtra("top5PjesamaMuzicara");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pjesme);
        listaTop5Pjesama.setAdapter(adapter);
        postaviListenerNaLink();
        postaviListenerNaPjesmu();
        postaviListenerNaDugme();
    }

    private void postaviListenerNaLink() {
        textViewWebStranicaMuzicara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getIntent().getStringExtra("webStranicaMuzicara")));
                startActivity(Intent.createChooser(intent,
                        getResources().getString(R.string.chooser_otvaranje_linka)));
            }
        });
    }

    private void postaviListenerNaPjesmu() {
        listaTop5Pjesama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mojIntent = new Intent(Intent.ACTION_VIEW);
                String[] imeIPrezimeRazdvojeni =
                        getIntent().getStringExtra("imeIPrezimeMuzicara").split(" ");
                String imeMuzicara = imeIPrezimeRazdvojeni[0];
                String prezimeMuzicara = imeIPrezimeRazdvojeni[1];
                String nazivPjesme = pjesme.get(position);
                mojIntent.setData(Uri.parse("https://www.youtube.com/results?search_query="
                        + imeMuzicara + "+" + prezimeMuzicara + "+" + nazivPjesme));
                mojIntent.setPackage("com.google.android.youtube");
                if (mojIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(mojIntent);
            }
        });
    }

    private void postaviListenerNaDugme() {
        dugmePodijeliBiografiju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mojIntent = new Intent(Intent.ACTION_SEND);
                mojIntent.setType("text/plain");
                mojIntent.putExtra(Intent.EXTRA_SUBJECT, "Biografija");
                mojIntent.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra("biografijaMuzicara"));
                startActivity(Intent.createChooser(mojIntent,
                        getResources().getString(R.string.chooser_naslov_podijeli_biografiju)));
            }
        });
    }
}

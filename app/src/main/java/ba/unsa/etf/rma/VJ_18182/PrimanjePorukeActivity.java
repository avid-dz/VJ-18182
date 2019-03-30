package ba.unsa.etf.rma.VJ_18182;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PrimanjePorukeActivity extends AppCompatActivity {

    private Button dugme;
    private EditText tekst;
    private ListView lista;
    private ListaMuzicaraAdapter adapter;
    private ArrayList<Muzicar> listaMuzicara = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        napuniListu();
        dugme = (Button) findViewById(R.id.button);
        tekst = (EditText) findViewById(R.id.editText);
        lista = (ListView) findViewById(R.id.listView);
        Resources resources = getResources();
        adapter = new ListaMuzicaraAdapter(this, listaMuzicara, resources);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mojIntent = new Intent(PrimanjePorukeActivity.this, PrikazDetaljaOMuzicaruActivity.class);
                mojIntent.putExtra("imeIPrezimeMuzicara", listaMuzicara.get(position).getImeIPrezime());
                mojIntent.putExtra("zanrMuzicara", listaMuzicara.get(position).getZanr());
                mojIntent.putExtra("biografijaMuzicara", listaMuzicara.get(position).getBiografija());
                mojIntent.putExtra("webStranicaMuzicara", listaMuzicara.get(position).getWebStranica());
                mojIntent.putStringArrayListExtra("top5PjesamaMuzicara", listaMuzicara.get(position).getListaTop5Pjesama());
                PrimanjePorukeActivity.this.startActivity(mojIntent);
            }
        });
        popuniEditTextPrimljenomPorukom();
    }

    private void napuniListu() {
        ArrayList<String> listaTop5Pjesama0 = new ArrayList<>();
        listaTop5Pjesama0.add("Oficir s ruzom");
        listaTop5Pjesama0.add("Stare slike");
        listaTop5Pjesama0.add("Večita igra ljubavi");
        listaTop5Pjesama0.add("Rođen spreman");
        listaTop5Pjesama0.add("Dukat srca");
        listaMuzicara.add(new Muzicar("Nedeljko Bajić Baja", "Folk",
                "http://www.nedeljkobajicbaja.com",
                "Nedeljko Bajić Baja (9. juni 1968. Šipovo, Jugoslavija) je srbijanski " +
                        "pop-folk pjevač porijeklom iz Bosne i Hercegovine. ", "folk1", listaTop5Pjesama0));
        ArrayList<String> listaTop5Pjesama1 = new ArrayList<>();
        listaTop5Pjesama1.add("Nema nikoga dugo");
        listaTop5Pjesama1.add("Zauvek");
        listaTop5Pjesama1.add("Voli me i ne voli");
        listaTop5Pjesama1.add("Najmanje");
        listaTop5Pjesama1.add("Lozinka za raj");
        listaMuzicara.add(new Muzicar("Željko Vasić", "Pop",
                "http://www.zeljkovasic.com", "Željko Vasić (rođen je 10. decembra 1979. " +
                "godine u Zaječaru) je srpski pop pevač, kompozitor i tekstopisac.", "pop1", listaTop5Pjesama1));
        ArrayList<String> listaTop5Pjesama2 = new ArrayList<>();
        listaTop5Pjesama2.add("Baraba");
        listaTop5Pjesama2.add("Duge kiše jesenje");
        listaTop5Pjesama2.add("21. vijek");
        listaTop5Pjesama2.add("Stari");
        listaTop5Pjesama2.add("Grbavica");
        listaMuzicara.add(new Muzicar("Mladen Vojičić Tifa", "Rock",
                "https://bs.wikipedia.org/wiki/Mladen_Vojičić_Tifa",
                "Mladen Vojičić, poznatiji po svom nadimku Tifa, " +
                        "(Sarajevo 17. listopada 1960.) bosanskohercegovački je rock pjevač. " +
                        "Postao je poznat diljem Jugoslavije po svom kratkotrajnom boravku na mjestu pjevača " +
                        "Bijelog dugmeta polovinom 1980-ih. Osim što je bio u Bijelom dugmetu, pjevao je u brojnim sastavima " +
                        "s različitim stupnjevima uspješnosti (Teška industrija, Vatreni poljubac i Divlje jagode). " +
                        "Danas, Tifa vodi solo karijeru.", "rock1", listaTop5Pjesama2));

    }

    private void popuniEditTextPrimljenomPorukom() {
        tekst.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
    }
}

package julio.salazar.guevara.imc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculaIMCFragment extends Fragment {
    EditText etPeso,etAltura;
    TextView tvResultado;
    ImageView ivResultado;
    Button btnCalcular;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaRaiz = inflater.inflate(R.layout.fragment_calcula_imc, container, false);

        etPeso = vistaRaiz.findViewById(R.id.etPeso);
        etAltura = vistaRaiz.findViewById(R.id.etAltura);
        tvResultado = vistaRaiz.findViewById(R.id.tvResultado);
        ivResultado = vistaRaiz.findViewById(R.id.ivResultado);
        btnCalcular = vistaRaiz.findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interpretarIMC(imc(etPeso.getText().toString(),etAltura.getText().toString()));
            }
        });

        return vistaRaiz;
    }
    private float imc(String StrPeso, String StrAltura){
        float peso = Float.parseFloat(StrPeso);
        float altura = Float.parseFloat(StrAltura);

        return peso/(altura*altura);
    }

    private void interpretarIMC(float imc){
        String Resultado = "";
        String urlFoto = "";
        if (imc < 18.5){
            Resultado = "Bajo peso";
            urlFoto = "https://static0.misionesonline.net/wp-content/uploads/2017/09/bajo-peso-61i7f7jofk70.jpg";
        }else if (imc > 18.5 && imc < 25){
            Resultado = "normal";
            urlFoto = "http://d3ustg7s7bf7i9.cloudfront.net/mmediafiles/pl/a6/a6540e59-47a7-4817-ad84-005147cc3fd1_879_586.jpg";
        }else{
            Resultado = "Sobrepeso";
            urlFoto = "http://www.elimparcial.com/Edicionenlinea/Fotos/VidayEstilo/1734687-N.JPG";
        }
        tvResultado.setText(Resultado);
        Picasso.get().load(urlFoto).into(ivResultado);
    }
}

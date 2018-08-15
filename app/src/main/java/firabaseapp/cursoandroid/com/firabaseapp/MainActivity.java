package firabaseapp.cursoandroid.com.firabaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = databaseReferencia.child("produtos").child("01");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add usuário no BD
        /*Usuario usuario = new Usuario();
        usuario.setNome("Fulano");
        usuario.setSobrenome("da Silva");
        usuario.setIdade(24);
        usuario.setSexo("Masculino");

        usuarioReferencia.child("03").setValue(usuario);*/


        //Add produto no BD
        /*Produto produto = new Produto();

        produto.setDescricao("Celular");
        produto.setCor("Preto");
        produto.setFabricante("Motorola");

        produtoReferencia.child("01").setValue(produto);*/

        produtoReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

package brg.bancodedadossqlite.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import brg.bancodedadossqlite.R;
import brg.bancodedadossqlite.controller.ClienteController;
import brg.bancodedadossqlite.databinding.ActivityCadastrarClienteBinding;
import brg.bancodedadossqlite.model.Cliente;

public class CadastrarClienteActivity extends AppCompatActivity {
    ActivityCadastrarClienteBinding binding;
    Cliente cliente;
    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityCadastrarClienteBinding.inflate(getLayoutInflater());

        assert binding != null;
        setContentView(binding.getRoot());

        binding.cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliente = new Cliente();
                cliente.setEmail(binding.email.getText().toString());
                cliente.setNome(binding.nome.getText().toString());
                cliente.setTelefone(binding.telefone.getText().toString());
                clienteController = new ClienteController(getApplicationContext());

                if (clienteController.incluir(cliente)) {
                    Toast.makeText(CadastrarClienteActivity.this, "Cliente Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CadastrarClienteActivity.this, "Erro ao Cadastrar Cliente!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

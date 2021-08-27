<template>
  <div>
    <!--Alerta para exibir uma mensagem de sucesso-->
    <v-alert
      :value="alert"
      dismissible
      transition="scale-transition"
      dense
      type="success"> <!--Mudar isso para quando for um erro-->
      {{alert_mensagem}}
    </v-alert>

    <v-card
      :loading="loading"
      class="mx-auto my-12"
      elevation="10"
      max-width="574"
      max-height="500">
      
      <v-card-title>Cadastrar produto</v-card-title>
      <v-layout class="flex" justify-center>
        <v-form
        ref="form"
        v-model="valid"
        lazy-validation>

          <v-text-field
            v-model="produto.nome"
            :counter="20"
            :rules="nomeRules"
            label="Nome do produto"
            persistent-hint
            outlined
            required>
          </v-text-field>

          <v-text-field
            v-model="produto.quantidade"
            label="Quantidade do produto"
            persistent-hint
            outlined
            required>
          </v-text-field>

          <v-text-field
            v-model="produto.valor"
            label="Preco do produto"
            persistent-hint
            outlined
            prefix="$"
            required>
          </v-text-field>

          <v-text-field
            v-model="produto.descricao"
            label="Descrição do produto"
            persistent-hint
            outlined
          ></v-text-field>

          <v-layout mt-5 mb-5>
            <v-btn
              :disabled="!valid"
              color="success"
              class="mr-15"
              @click="validate">
              Cadastrar Produto
            </v-btn>

            <v-btn
              mb-5
              color="warning"
              @click="reset">
              Resetar Formulario
            </v-btn>


          </v-layout>

        </v-form>

      </v-layout>

    </v-card>

  

  </div>

</template>

<script>
import ProdutoAPI from '../services/produtos'
  export default {

    created(){
      //Se o aux não for nulo
      //Quer dizer que eu quero editar o produto
      this.aux = this.$route.params.produto;
      if(this.aux != null){
        //para receber o objetivo que eu passei pela tela de listar
        this.produto = this.$route.params.produto;
      }
    },

    //dados que serão utilizados na tela
    data: () => ({
      aux:'',
      produto:{
        nome: '',
        quantidade: '',
        valor: '',
        descricao: '',
        showDesc: false,
      },

      //variaveis para o alert
      //quero fazer lee trocar de cor se for sucess ou error
      alert: false,
      alert_tipo: "",
      alert_mensagem: "",
      //variavel para o botão de confirmar
      valid: true,
      //regras para o input do nome
      nomeRules: [
        v => !!v || 'Este campo é obrigatório',
        v => (v && v.length <= 20) || 'Name must be less than 10 characters',
      ],

    }),

    //metodos utilizados na view
    methods: {
      validate () {
        //se o formulário for válido
          if(this.$refs.form.validate()){
              //salvar no banco
              this.salvarbanco()
          }
      },
      
      salvarbanco(){
      //Se o id for nulo cria um novo produto no banco
      if(this.produto.id == null){
         ProdutoAPI.salvar(this.produto).then(res =>{
                //fazer tratamento de erro depois.  
                console.log("Produto salvo com sucesso!", res);
                this.alert_tipo = "sucess"
                this.alert = true;
                this.alert_mensagem = "Produto salvo com sucesso!"

                //limpar os campos
                this.reset()
              }).catch(e => {
                this.alert_mensagem = e.response.data.errors[0]
                console.log("Erro: "+e.response.data.errors[0])
              })

      }else{
          ProdutoAPI.editar(this.produto).then(res =>{
                //fazer tratamento de erro depois.  
                console.log("Produto atualizado com sucesso!", res);
                this.alert_tipo = "sucess"
                this.alert = true;
                this.alert_mensagem = "Produto atualizado com sucesso!"
                //limpar os campos
                this.reset()
              }).catch(e => {
                this.alert_mensagem = e.response.data.errors[0]
                console.log("Erro: "+e.response.data.errors[0])
              })
      }},
       reset () {
        this.$refs.form.reset()
      },
    },
      
   
  }
</script>
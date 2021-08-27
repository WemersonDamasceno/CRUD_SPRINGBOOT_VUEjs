<template>
    <v-card>
      <v-card-title>
        Lista de Produtos
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>

        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Procurar"
          single-line
          hide-details>
        </v-text-field>
      </v-card-title>
        
      <div class="grid-container">
        <div class="grid-item"
         v-for="produto of filteredProdutos" :key="produto.id">
         
         <v-card id = "produto"  aspect-ratio="2.75">  
        
          <div id = "div_nome">
            <h3 id= "atributo">Nome: </h3> 
            <h3>{{produto.nome |to-uppercase}}</h3>
        </div>

        <div id = "div_nome">
            <h3 id= "atributo">Quantidade: </h3> 
            <h3>{{produto.quantidade}}</h3>
        </div>
        
        <div id = "div_nome">
            <h3 id= "atributo">Valor: </h3> 
            <h3>{{produto.valor}}</h3>
        </div>

        <v-card-actions>
         
            <router-link style='text-decoration: none; margin-right:10px' :to="{ name: 'Formulario',  params: { produto: produto}}">
              <v-btn color="blue"  class="white--text">
                <v-icon left color="white">
                  mdi-pencil
                </v-icon>  
                Editar
               </v-btn>
            </router-link>

            <v-spacer></v-spacer>

            <v-btn
                color="red"
                @click="remover(produto)"
                class="white--text">
               <v-icon left color="white">
                mdi-trash-can-outline</v-icon>Excluir
            </v-btn>

            <v-spacer></v-spacer>

            <v-btn
              icon
              @click="produto.showDesc = !produto.showDesc">
              <v-icon>{{ produto.showDesc ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
            </v-btn>
          </v-card-actions>

          <v-expand-transition>
            <div v-show="produto.showDesc">
              <v-divider></v-divider>

              <v-card-text>
                <p>{{produto.descricao}}</p>
              </v-card-text>
            </div>
          </v-expand-transition>

    </v-card>
        </div>
      </div>
    </v-card> 

</template>


<script>
import ProdutoApi from '../services/produtos'
export default { 
  data(){
    return{
      search: '',
      listProdutos: [],
      produto: {
        id: '',
        nome: '',
        quantidade: '',
        valor: '',
        showDesc: false,
      }
    }
  },

  computed:{
    filteredProdutos: function(){
      return this.listProdutos.filter((p =>{
        var nome = p.nome.toUpperCase()
        console.log(nome)
        return nome.match(this.search.toUpperCase())
      }))
    }
  },

  mounted() {
    this.listarProdutos()
  },

  methods:{
    listarProdutos(){
       ProdutoApi.listar().then(res =>{
        console.log(res.data)
        this.listProdutos = res.data
      })
    },

    remover(produto){
      if(confirm("Deseja deletar esse produto?")){
        ProdutoApi.deletar(produto).then(res =>{
          console.log("removido com sucesso", res)
          this.listarProdutos()
        })
      }
      
    }
  }


}
</script>

<style>
  .grid-container {
    display: grid;
    grid-template-columns: auto auto auto;
    padding: 20px;
  }
  .grid-item {
    padding: 40px;
    background-color: rgba(248, 248, 248, 0.8);
    text-align: center;
  }

  #produto{
        height: auto;
        font-size: 14px;
        text-align: center;
        padding: 10px;
        background: #f8f8f8;
    }


    #atributo{
        color: black;
        font-size: 22px;
        font-weight: bold;
        margin-right: 10px;
    }

    #div_nome{
        display: flex;
        font-size: 18px;
        font-weight: bold;
        color: rgb(41, 41, 41);
    }
    



</style>
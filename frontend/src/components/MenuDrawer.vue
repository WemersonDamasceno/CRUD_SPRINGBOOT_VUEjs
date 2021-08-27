<template>
  <div>
    <v-toolbar color="blue" app class="white--text">
      <v-app-bar-nav-icon class="white--text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Gestão de Produtos</v-toolbar-title>      
    </v-toolbar>

    <v-navigation-drawer app v-model="drawer" temporary>
      <v-layout column align-center mt-4>
        <v-flex>
          <v-avatar>
            <img
            src="https://avatars0.githubusercontent.com/u/9064066?v=4&s=460"/>
          </v-avatar>
        </v-flex>  
        <h3 style="margin-top: 10px">Wemerson Monteiro</h3>     
      </v-layout>
      
      <!--layout dos itens do menu-->
      <v-layout mt-5>
        <v-list>
        <!-- Para cada item na list de item rederize seu icone e titulo-->
        <v-list-item
          v-for="item in items" :key="item.title" link :to="item.path">
          <!--Icone-->
          <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>
          <!--Titulo-->
          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list> 
      </v-layout>
      
     </v-navigation-drawer>
    
  </div>
</template>

<script>

export default {

  data(){
    return{
      drawer: false,
       items: [
          { title: 'Pagina Incial', icon: 'mdi-home', path: '/'},
          { title: 'Cadastrar Produto', icon: 'mdi-content-save', path: '/formulario'},
          { title: 'Listar Produto', icon: 'mdi-format-list-bulleted-square' , path: '/produtos'},
        ],
    }
  }
};
</script>


<style>
</style>

<template>
<v-layout class="flex" justify-center mt-10>
  <v-stepper v-model="e1">
    <v-stepper-header>
      <v-stepper-step
        :complete="e1 > 1"
        step="1">
        Pagina Inicial
      </v-stepper-step>

      <v-divider></v-divider>

      <v-stepper-step
        :complete="e1 > 2"
        step="2">
        Cadastrar Produtos
      </v-stepper-step>

      <v-divider></v-divider>

      <v-stepper-step step="3">
        Listar produtos
      </v-stepper-step>
    </v-stepper-header>


    <v-stepper-items>
      <v-stepper-content step="1">
        <v-card
          height="250px"
          width="500px">
        <img src="../assets/gestao.jpeg" width="500" height="200">
        <p>Gestão de produtos</p>
        
        </v-card>

        <v-btn
          color="primary"
          @click="e1 = 2"
        >
          Próximo
        </v-btn>

        <v-btn text>
          Cancelar
        </v-btn>
      </v-stepper-content>

      <v-stepper-content step="2">
        <v-card
          class="mb-12"
          color="grey lighten-1"
          height="200px">

           <img src="../assets/cap_1.jpeg" width="500" height="200">
        <p>Formulário para cadastrar produtos</p>
        
        
        </v-card>

        <v-btn
          color="primary"
          @click="e1 = 3"
        >
          Continue
        </v-btn>

        <v-btn text>
          Cancel
        </v-btn>
      </v-stepper-content>

      <v-stepper-content step="3">
        <v-card
          class="mb-12"
          color="grey lighten-1"
          height="200px">
        
            <img src="../assets/cap_2.jpeg" width="500" height="200">
            <p>Listagem de todos os produtos</p>
        
          </v-card>

        <v-btn
          color="primary"
          @click="e1 = 1"
        >
          Continue
        </v-btn>

        <v-btn text>
          Cancel
        </v-btn>
      </v-stepper-content>
    </v-stepper-items>
    
  </v-stepper>
  </v-layout>
</template>

<script>
export default {
    data () {
      return {
        e1: 1,
      }
    },
}
</script>
<template>
  <v-app>
    <div id="app">
      <MenuDrawer/>
    <router-view/>
    </div>
  </v-app>
</template>

<script>
import MenuDrawer from './components/MenuDrawer'
export default {
  components:{
    MenuDrawer,
  }
}
</script>

<style>

</style>

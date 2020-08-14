<template>
  <div>
    <navMenu></navMenu>
    <router-view></router-view>
  </div>
</template>

<script>
import NavMenu from './common/NavMenu'
export default {
  name: 'Home',
  components: {NavMenu}
}
</script>

<style>

</style>

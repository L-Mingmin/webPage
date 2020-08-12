<template>
  <div>
    <NavMenu></NavMenu>
    <HomeIndex></HomeIndex>
    <router-view></router-view>
  </div>
</template>

<script>
import NavMenu from './common/NavMenu'
import HomeIndex from './common/home/HomeIndex'
export default {
  name: 'Home',
  components: {NavMenu, HomeIndex}
}
</script>

<style>

</style>

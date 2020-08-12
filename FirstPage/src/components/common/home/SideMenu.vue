<template>
  <el-menu
    default-active="0"
    class="category"
    @select="handleSelect"
    active-text-color="red"
  >
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">教育</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">公安</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-menu"></i>
      <span slot="title">法院</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu',
  data () {
    return {
      cid: ''
    }
  },
  methods: {
    handleSelect (key) {
      this.cid = key
      this.$emit('indexSelect')
    }
  }
}
</script>

<style>
.category {
  position: fixed;
  margin-left: auto;
}
</style>

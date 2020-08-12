<template>
  <el-container>
      <el-aside style="width: 200px; margin-top: 20px">
        <sideMenu @indexSelect="listByCategory" ref="sideMenu"></sideMenu>
      </el-aside>
      <el-main>
        <projects class="projectsArea" ref="projectsArea"></projects>
      </el-main>
    </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Projects from './Projects'
export default{
  name: 'HomeIndex',
  components: {SideMenu, Projects},
  methods: {
    listByCategory () {
      var cid = this.$refs.sideMenu.cid
      var url = 'categories/' + cid + '/projects'
      this.$axios
        .get(url)
        .then(successResponse => {
          if (successResponse.status === 200) {
            this.$refs.projectsArea.projects = successResponse.data
          }
        })
        .catch(failResponse => {
          console.log('刷新失败')
        })
    }
  }
}
</script>

<style>
</style>

<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="2"
        class="el-menu-vertical-demo">
      <el-submenu index="1-4">
        <template #title>选项一</template>
        <el-menu-item index="1-4-1">选项1-1</el-menu-item>
      </el-submenu>
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <template #title>选项二</template>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-menu"></i>
        <template #title>选项四</template>
      </el-menu-item>
    </el-menu>

  </div>
</template>

<script>
// import request from "@/utils/request";

export default {
  name: "Aside",
  // data() {
  //   return {
  //     user: {}
  //   }
  // },
  // created() {
  //   let userStr = sessionStorage.getItem("user") || "{}"
  //   this.user = JSON.parse(userStr)
  //
  //   // 请求服务端，确认当前登录用户的 合法信息
  //   request.get("/user/" + this.user.id).then(res => {
  //     if (res.code === '0') {
  //       this.user = res.data
  //     }
  //   })
  // }
}
</script>

<style scoped>

</style>

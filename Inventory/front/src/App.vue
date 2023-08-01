<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div>
    <el-menu
        class="el-menu-vertical-demo"
    >
      <el-menu-item index="1">
        <template #title>
          <el-icon>
            <location/>
          </el-icon>
          <RouterLink to="/">입출고 관리</RouterLink>
        </template>
      </el-menu-item>
      <el-menu-item index="2">
        <el-icon>
          <icon-menu/>
        </el-icon>
        <RouterLink to="/write">재고 관리</RouterLink>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon>
          <setting/>
        </el-icon>
        <RouterLink to="/write">지점 관리</RouterLink>
      </el-menu-item>
    </el-menu>
    <nav>

    </nav>
  </div>

  <RouterView />
</template>

<style>

</style>

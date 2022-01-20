<template>
  <div>
    Welcome, USER_PLACEHOLDER

    <activity-feed/>
    <calendar/>
  </div>
</template>

<script>
import ActivityFeed from "@/components/ActivityFeed";
import Calendar from "@/components/Calendar";

export default {
  name: "Profile",
  components: {Calendar, ActivityFeed}
}
</script>

<style scoped>

</style>
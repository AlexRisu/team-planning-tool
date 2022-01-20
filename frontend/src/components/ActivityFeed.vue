<template>
  <v-container>
    <v-timeline
        align-top
        :dense="$vuetify.breakpoint.smAndDown"
    >
      <v-timeline-item
          v-for="(item, i) in activityFeedPlaceholder"
          :key="i"
          :color="item.color"
          :icon="item.icon"
          fill-dot
      >
        <v-card
            :color="item.color"
            dark
        >
          <v-card-title class="text-h6">
            {{ item.activity.title }}
          </v-card-title>
          <v-card-text class="white text--primary">
            <p>
              {{ item.activity.description }}
            </p>
            <v-btn
                :color="item.color"
                class="mx-0"
                outlined
            >
              Button
            </v-btn>
          </v-card-text>
          <span class="activity-time">
            {{ item.activity.date.getHours() }} Hours ago
          </span>
        </v-card>
      </v-timeline-item>
    </v-timeline>
  </v-container>
</template>

<script>
export default {
  name: "ActivityFeed",
  props: {
    data: {type: Array, required: false,}
  },
  data() {
    return {
      activityFeedPlaceholder: [
        {
          user: 'Markus',
          activity: {
            title: 'testActivity - 1',
            description: 'hey this is a testActivity done by Markus!',
            date: new Date(),
          },
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          user: 'Thomas',
          activity: {
            title: 'testActivity - 2',
            description: 'hey this is a testActivity done by Thomas!',
            date: new Date(),
          },
          color: 'purple',
          icon: 'mdi-book-variant',
        },
      ],
    }
  },
  created() {
    if (this.data) {
      this.activityFeedPlaceholder = this.data;
    }
  }
}
</script>

<style scoped>
.activity-time {
  position: absolute;
  bottom: 5px;
  right: 5px;
  font-size: 8pt;
  color: #7f7f7f;
}
</style>
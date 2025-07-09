# ToDoRandomizer API Documentation

## AdhdAssistantController (`/AdhdAssistant/v1`)

| Method | Path                | Params/Body                        | Description                                      |
|--------|---------------------|------------------------------------|--------------------------------------------------|
| GET    | `/getSchedule`      | `userId` (query param)             | Get the schedule for a user                      |
| GET    | `/getCurrentTask`   | `userId` (query param)             | Get the current task(s) for a user               |
| GET    | `/setCurrentTask`   | `userId`, `newTaskId` (query param)| Set a new current task for a user                |
| GET    | `/getRandomTask`    | `userId` (query param)             | Set a random task to in-progress for a user      |
| GET    | `/getGoals`         | `userId` (query param)             | Get all goals for a user                         |
| POST   | `/setGoal`          | `Goal` (JSON body)                 | Create or update a goal                          |

---

## ManifestorController (`/manifestor/v1`)

| Method | Path         | Params/Body         | Description                |
|--------|--------------|---------------------|----------------------------|
| POST   | `/addGoal`   | `Goal` (JSON body)  | Add a new goal             |
| POST   | `/addTask`   | `Task` (JSON body)  | Add a new task             |

---

## OnboardController (`/onboard/v1`)

| Method | Path         | Params/Body                | Description                        |
|--------|--------------|----------------------------|------------------------------------|
| POST   | `/addUser`   | `CalendarUser` (JSON body) | Add a new user                     |
| POST   | `/updateUser`| `CalendarUser` (JSON body) | Update an existing user            |

---

## SchedulerController (`/scheduler`)

| Method | Path                | Params/Body                | Description                        |
|--------|---------------------|----------------------------|------------------------------------|
| POST   | `/createCalendar`   | `Calendar` (JSON body)     | Create a new calendar              |
| POST   | `/createAppointment`| `Appointment` (JSON body)  | Create a new appointment           |

---

**Notes:**
- All endpoints return JSON responses.
- For POST endpoints, the request body should be a JSON representation of the corresponding entity (`Goal`, `Task`, `CalendarUser`, `Calendar`, or `Appointment`).
- For GET endpoints with query parameters, supply them as URL query strings (e.g., `/getSchedule?userId=1`). 
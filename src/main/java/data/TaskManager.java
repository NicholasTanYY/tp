package data;

import storage.Storage;
import time.WeekView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static data.TaskManagerException.checkIfDateHasTasks;
import static data.TaskManagerException.checkIfDateInCurrentWeek;
import static data.TaskManagerException.checkIfDateInCurrentMonth;
import static storage.Storage.saveTasksToFile;


public class TaskManager {
    private static final Map<LocalDate, List<String>> tasks = new HashMap<>();

    public static void addTask(LocalDate date, String task) {
        tasks.computeIfAbsent(date, k -> new ArrayList<>()).add(task);
    }

    public void deleteTask(LocalDate date, int taskIndex) {
        List<String> dayTasks = tasks.get(date);
        if (dayTasks != null && taskIndex >= 0 && taskIndex < dayTasks.size()) {
            dayTasks.remove(taskIndex);
            if (dayTasks.isEmpty()) {
                tasks.remove(date);
            }
        }
    }

    public static void updateTask(LocalDate date, int taskIndex, String updatedTask) throws IndexOutOfBoundsException {
        try {
            List<String> dayTasks = tasks.get(date);
            boolean dayHasTasks = dayTasks != null;
            boolean taskIndexExists = taskIndex >= 0 && taskIndex < Objects.requireNonNull(dayTasks).size();
            if (dayHasTasks && taskIndexExists) {
                dayTasks.set(taskIndex, updatedTask);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }


    public List<String> getTasksForDate(LocalDate date) {
        return tasks.getOrDefault(date, new ArrayList<>());
    }

    /**
     * Prompts user for task description and adds task to hashmap and tasks.txt file
     *
     * @param scanner User input
     * @param weekView Current week being viewed
     * @param inMonthView Whether month is being viewed
     * @throws TaskManagerException Throws exception when not in correct week/month view
     */
    public static void addManager(Scanner scanner, WeekView weekView, boolean inMonthView)
            throws TaskManagerException, DateTimeParseException {
        System.out.println("Enter the date for the task (dd/MM/yyyy):");
        LocalDate date = parseInputDate(scanner);

        if (inMonthView) {
            checkIfDateInCurrentMonth(date);
        } else {
            checkIfDateInCurrentWeek(date, weekView);
        }

        System.out.println("Enter the task description:");
        String task = scanner.nextLine().trim();

        addTask(date, task);
        saveTasksToFile(tasks, Storage.FILE_PATH); // Updates tasks from hashmap into tasks.txt file
        System.out.println("Task added.");
    }

    /**
     * Prompts user for updated task description
     *
     * @param scanner User input
     * @param weekView Current week being viewed
     * @param inMonthView Whether month is being viewed
     * @throws TaskManagerException Throws exception when not in correct week/month view
     */
    public static void updateManager(Scanner scanner, WeekView weekView, boolean inMonthView,TaskManager taskManager)
            throws TaskManagerException, DateTimeParseException {
        System.out.println("Enter the date for the task you wish to update (dd/MM/yyyy):");
        LocalDate date = parseInputDate(scanner);

//        checkIfDateInCurrentWeek(date, weekView);

        if (inMonthView) {
            checkIfDateInCurrentMonth(date);
        } else {
            checkIfDateInCurrentWeek(date, weekView);
        }

        listTasksAtDate(taskManager, date, "Enter the task number of the task you wish to update:");

        int taskNumber;
        String updatedDescription;

        try {
            taskNumber = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Enter the updated task description:");
            updatedDescription = scanner.nextLine().trim();

            updateTask(date, taskNumber - 1, updatedDescription);
            saveTasksToFile(tasks,Storage.FILE_PATH); //Update tasks.txt file
            System.out.println("Task updated.");
        } catch (NumberFormatException e) {
            System.out.println("Task number should be an integer value. Please try again.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The task number you have entered does not exist. Please try again.");
        }

    }

    /**
     * Scans through hashmap and adds tasks to formatted tasks.txt
     *
     * @param tasksFromFile Hashmap of tasks
     */
    public void addTasksFromFile(Map<LocalDate, List<String>> tasksFromFile) {
        for (Map.Entry<LocalDate, List<String>> entry : tasksFromFile.entrySet()) {
            LocalDate date = entry.getKey();
            List<String> taskList = entry.getValue();
            for (String task : taskList) {
                addTask(date, task);
            }
        }
    }

    /**
     *
     *
     * @param taskManager Hashmap of tasks
     * @param date Date thats prompted by user
     * @param message Message to be prompted to the user
     * @throws TaskManagerException Throws exception when not in correct week/month view
     */
    private static void listTasksAtDate(TaskManager taskManager, LocalDate date, String message)
            throws TaskManagerException {
        List<String> dayTasks = taskManager.getTasksForDate(date);
        checkIfDateHasTasks(dayTasks);

        System.out.println(message);
        for (int i = 0; i < dayTasks.size(); i++) {
            System.out.println((i + 1) + ". " + dayTasks.get(i));
        }
    }

    /**
     * Prompts user for task description and deletes task from hashmap and tasks.txt file
     *
     * @param scanner User input
     * @param weekView Current week being viewed
     * @param inMonthView Whether month is being viewed
     * @throws TaskManagerException Throws exception when not in correct week/month view
     */
    public static void deleteManager(Scanner scanner, WeekView weekView, boolean inMonthView, TaskManager taskManager)
            throws DateTimeParseException, TaskManagerException {

        System.out.println("Enter the date for the task to delete (dd/MM/yyyy):");
        LocalDate date = parseInputDate(scanner);

//        checkIfDateInCurrentWeek(date, weekView);

        if (inMonthView) {
            checkIfDateInCurrentMonth(date);
        } else {
            checkIfDateInCurrentWeek(date, weekView);
        }

        listTasksAtDate(taskManager, date, "Enter the task number to delete:");

        int taskNumber;

        try {
            taskNumber = Integer.parseInt(scanner.nextLine().trim());
            taskManager.deleteTask(date, taskNumber - 1);
            System.out.println("Task deleted.");
            saveTasksToFile(tasks, Storage.FILE_PATH); //Update tasks.txt file
        } catch (NumberFormatException e) {
            System.out.println("Invalid task number. Please try again.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The task number you have entered does not exist. Please try again.");
        }
    }

    // to abstract as Parser/UI function

    /**
     * Parses user input into date time format
     *
     * @param scanner User Input
     * @return Formatted date time from user input
     * @throws DateTimeParseException Throws exception is user input is not in correct format
     */
    private static LocalDate parseInputDate(Scanner scanner) throws DateTimeParseException {
        String dateString = scanner.nextLine().trim();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(dateString, dateFormatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid date format. Please use the format dd/MM/yyyy.", dateString, 0);
        }
        return date;
    }

}

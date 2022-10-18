package executor;

public class Main {
	public static void main(String[] args) {
        InterfaceTaskStorage taskStorage = new TaskStorage("ts");
        InterfaceTaskScheduler scheduler = new TaskScheduler(taskStorage, 10);

        TaskAction task = TaskAction.ofScript("script.js", "5s", true, true);

        scheduler.scheduleTask(task);

        scheduler.mostrarStoredSchedules();
    }
}

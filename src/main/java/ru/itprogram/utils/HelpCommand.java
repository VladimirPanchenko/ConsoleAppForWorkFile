package ru.itprogram.utils;

public class HelpCommand implements Command {
    private final String KEY_COMMAND = "help";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        System.out.println("help - список доступных комманд\n" +
                "createFile path_to_file - создать файл по заданному пути\n" +
                "writeFile (-a) path_to_file content - записать или дописать строку в файл\n" +
                "cp (-a) source_file dest_file - скопировать файл или дописать скопированное\n" +
                "deleteFile path_to_file - удалить файл\n" +
                "zip path_to_zip_file files - поместить файлы в Zip архив\n" +
                "cat path_to_file - распечатать содержимое файла в консоль\n" +
                "exit - выход из программы\n" +
                "ключ -a - дополнительный параметр, если нужно писать в конец файла\n");
    }
}

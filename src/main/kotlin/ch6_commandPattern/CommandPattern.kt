package ch6_commandPattern

// Command Interface
interface Command {
    fun execute()
    fun undo()
}

// Receiver
class TextEditor {
    private var text: String = ""

    fun writeText(newText: String) {
        text += newText
    }

    fun getText(): String = text

    fun deleteText(length: Int) {
        text = text.dropLast(length)
    }
}

// Concrete Command
class WriteCommand(private val editor: TextEditor, private val textToWrite: String) : Command {
    override fun execute() {
        editor.writeText(textToWrite)
    }

    override fun undo() {
        editor.deleteText(textToWrite.length)
    }
}

// Invoker
class TextEditorInvoker {
    private val commandHistory = mutableListOf<Command>()
    private var currentCommandIndex = -1

    fun executeCommand(command: Command) {
        command.execute()
        if (currentCommandIndex < commandHistory.size - 1) {
            commandHistory.subList(currentCommandIndex + 1, commandHistory.size).clear()
        }
        commandHistory.add(command)
        currentCommandIndex++
    }

    fun undo() {
        if (currentCommandIndex >= 0) {
            commandHistory[currentCommandIndex].undo()
            currentCommandIndex--
        }
    }

    fun redo() {
        if (currentCommandIndex < commandHistory.size - 1) {
            currentCommandIndex++
            commandHistory[currentCommandIndex].execute()
        }
    }
}

// Client
fun main() {
    val editor = TextEditor()
    val invoker = TextEditorInvoker()

    val writeHello = WriteCommand(editor, "Hello ")
    val writeWorld = WriteCommand(editor, "World!")

    invoker.executeCommand(writeHello)
    invoker.executeCommand(writeWorld)

    println(editor.getText()) // Output: Hello World!

    invoker.undo()
    println(editor.getText()) // Output: Hello

    invoker.redo()
    println(editor.getText()) // Output: Hello World!
}
package com.wwq.eleven

/**
 * 命令模式
 * Created by wwq on 2017/12/13.
 */
class TetrisMachine {
    var toLeft = println("向左")
    var toRight = println("向右")
    var fastToBottom = println("快速落下")
    var transform = println("改变形状")
}

class FallCommand(val machine: TetrisMachine) : Command {
    override fun execute() = machine.fastToBottom
}

class LeftCommand(val machine: TetrisMachine) : Command {
    override fun execute() = machine.toLeft
}

class RightCommand(val machine: TetrisMachine) : Command {
    override fun execute() = machine.toRight
}

class TransformCommand(val machine: TetrisMachine) : Command {
    override fun execute() = machine.transform
}

class Buttons(leftCommand: LeftCommand, rightCommand: RightCommand, fallCommand: FallCommand, transformCommand: TransformCommand) {
    var toLeft = leftCommand.execute()
    var toRight = rightCommand.execute()
    var fall = fallCommand.execute()
    var transform = transformCommand.execute()
}

fun main(args: Array<String>) {
    var machine = TetrisMachine()
    var leftCommand = LeftCommand(machine)
    var rightCommand = RightCommand(machine)
    var fallCommand = FallCommand(machine)
    var transformCommand = TransformCommand(machine)

    var buttons = Buttons(leftCommand,rightCommand,fallCommand,transformCommand)
    buttons.toLeft
    buttons.toRight
    buttons.fall
    buttons.transform
}
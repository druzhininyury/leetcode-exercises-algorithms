import os
import tkinter as tk
from tkinter import messagebox

BLANK_GEN_FOLDER = "blank-gen"
DESCRIPTIONS_FOLDER = "descriptions"
ALGORITHM_FOLDER = "src\\main\\java\\ru\\druzhininyy\\leetcode\\exercises\\algorithms"
TEST_FOLDER = "src\\test\\java\\ru\\druzhininyy\\leetcode\\exercises\\algorithms"
TEST_RESOURCES_FOLDER = "src\\test\\resources"


def create_problem_blank():
    folder_number = entry.get()
    if not folder_number.isdigit():
        messagebox.showerror("Error", "Enter problem number.")
        return

    suffix_number = "{:0>4}".format(folder_number)

    # Creating problem description blank.
    copy_file(os.path.join(BLANK_GEN_FOLDER, "template.md"),
              os.path.join(DESCRIPTIONS_FOLDER, f"problem{suffix_number}.md"))

    # Create Solution class.
    algorithm_problem_folder = os.path.join(ALGORITHM_FOLDER, "problem" + suffix_number)
    os.makedirs(algorithm_problem_folder, exist_ok=True)
    with open(os.path.join(algorithm_problem_folder, "Solution.java"), 'w') as solution_file:
        solution_file.write("")

    # Create testcase file.
    with open(os.path.join(TEST_RESOURCES_FOLDER, f"problem{suffix_number}.json"), "w") as testcase_file:
        testcase_file.write("[\n  {\n\n  }\n]")

    # Create SolutionTest class.
    test_problem_folder = os.path.join(TEST_FOLDER, f"problem{suffix_number}")
    os.makedirs(test_problem_folder, exist_ok=True)
    copy_file(os.path.join(BLANK_GEN_FOLDER, "SolutionTest.java"),
              os.path.join(test_problem_folder, "SolutionTest.java"))

    root.quit()


def copy_file(source, destination):
    with open(source, 'rb') as source_file:
        with open(destination, 'wb') as destination_file:
            for chunk in iter(lambda: source_file.read(4096), b''):
                destination_file.write(chunk)


print("Текущая рабочая директория:", os.getcwd())
root = tk.Tk()
root.title("Problem blank generator")
root.geometry("300x150")

label = tk.Label(root, text="Enter problem number:")
label.pack(pady=10)

entry = tk.Entry(root)
entry.pack(pady=5)

create_button = tk.Button(root, text="Create", command=create_problem_blank)
create_button.pack(pady=10)

root.mainloop()

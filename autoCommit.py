import os
import time
import subprocess


if __name__=="__main__":
    # 获取当前日期和时间
    now = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())

    print("=" * 50)
    print(f"{' '*10}Starting autoCommit.py")
    print("=" * 50)

    # 切换到当前脚本所在目录
    script_dir = os.path.dirname(os.path.abspath(__file__))
    os.chdir(script_dir)

    # 执行 Git 命令
    subprocess.run(["git", "pull", "origin", "master"])
    subprocess.run(["git", "status"])
    subprocess.run(["git", "add", "."])
    subprocess.run(["git", "commit", "-m", f"{now}"])
    subprocess.run(["git", "push", "origin", "master"])

    # 暂停等待用户输入
    input("Press Enter to continue...")


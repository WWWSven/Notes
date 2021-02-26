# 根据 workPath 遍历出所有md的 ![imgName](imagePath/a.png) 中的 imageName 存在 mdImageList 里
# 遍历 .\image 下所有图片，存在 imageList 里
# 两者取差，删除图片
import os
import re


class clear:
    workPath = ''
    imageList = []
    mdImageList = []

    def __init__(self, workPath):
        self.workPath = workPath
        self.imageList = os.listdir(workPath + '\\.image\\')

    # 获取 md 文件中的 图片信息
    def get_markdown_imageInfo(self):
        md = []
        for root, ds, fs in os.walk(self.workPath):
            for f in fs:
                if f.endswith('.md'):
                    md.append(os.path.join(root, f))
        for i in md:
            with open(i, 'r', encoding='UTF-8') as f:
                read = f.read(1024)
                re_findall = re.findall('!\[.*?\]\((.*?)\)', read, re.S)
                for i in re_findall:
                    self.mdImageList.append(os.path.basename(i))
        return self.mdImageList

    # 获取 图片文件夹 下的 图片信息
    def get_image_folder_imageInfo(self):
        return self.imageList


if __name__ == '__main__':
    # .image文件夹的绝对路径
    abspath = os.path.abspath('.')
    tool = clear(abspath)
    delImage = list(set(tool.get_image_folder_imageInfo()).difference(set(tool.get_markdown_imageInfo())))
    for i in delImage:
        os.remove(abspath + '\\.image\\' + i)

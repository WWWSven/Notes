'use client'
import {
  Calendar,
  ChevronDown,
  ChevronRight,
  File,
  Folder,
  FolderCode,
  Home,
  Inbox,
  Search,
  Settings
} from "lucide-react"

import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem, SidebarMenuSub, SidebarMenuSubButton, SidebarMenuSubItem,
} from "@/components/ui/sidebar"
import {GitBlob} from "@/app/api/repos/trees/route";
import Link from "next/link";
import {useEffect, useState} from "react";
import {Collapsible, CollapsibleContent, CollapsibleTrigger } from "@/components/ui/collapsible";
import {cn} from "@/lib/utils";

type Tree = (GitBlob & {
  children: Tree
})[]

export function AppSidebar({
  data
}: {
  data: GitBlob[]
}) {
  const [tree, setTree] = useState(data as Tree)

  const CollapsibleCustom = ({triggerArg, contentArg}: {triggerArg: GitBlob, contentArg: Tree}) => {
    const [isOpen, setIsOpen] = useState(false) // 每个文件夹独立的状态
    const [trigger, setTrigger] = useState(triggerArg)
    const [content, setContent] = useState(contentArg)
    const [skeleton, setSkeleton] = useState<boolean>(false)

    function fetchBySha(){
      setSkeleton(true)
      fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/repos/trees/${trigger.sha}`, {cache: "no-store"}).then(
        value => {
          value.json().then(r => {
            setContent(r)
            setIsOpen(!isOpen)
          })
        },
        reason => {
          alert(reason)
        }
      ).finally(()=>{
        setSkeleton(false)
      })
    }

    return (
      <>
        <SidebarMenuItem>
          <SidebarMenuButton asChild
           className={cn(
             skeleton?'animate-pulse':'',
             isOpen?'bg-secondary/80':'',
           )}
          >
            {trigger.type == 'tree' ?
              <div onClick={fetchBySha}>
                <FolderCode/>
                <span>{trigger.path}</span>
                <ChevronRight
                  className={`ml-auto transition-transform ${isOpen? 'rotate-90': ''}`}/>
              </div>
              :
              <Link href={`/post/${trigger.sha}`}>
                <File/>
                <span>{trigger.path}</span>
              </Link>
            }
          </SidebarMenuButton>
        </SidebarMenuItem>
        {isOpen && content?.map(item=>(
          <SidebarMenuSub key={item.sha + item.path}>
            <CollapsibleCustom triggerArg={item} contentArg={item.children} />
          </SidebarMenuSub>
        ))}
      </>
    )
  }

  return (
    <Sidebar>
      <SidebarContent>
        <SidebarMenu>
          {tree.map(item=>{
            return <CollapsibleCustom
              triggerArg={item}
              contentArg={item.children}
              key={item.sha + item.path}
            />
          })}
        </SidebarMenu>
      </SidebarContent>
    </Sidebar>
  )
}

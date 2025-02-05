import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";
import {AppSidebar} from "@/components/app-sidebar";
import {SidebarProvider, SidebarTrigger} from "@/components/ui/sidebar";
import {GitBlob} from "@/app/api/repos/trees/route";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "AB :)",
  description: "sven.org.cn",
};

export default async function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  const res: Response = await fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/repos/trees`, {cache: "no-store"})
  const data: GitBlob[] = await res.json()

  return (
    <html lang="en" className={'dark'}>
    <body
      className={`${geistSans.variable} ${geistMono.variable} antialiased`}
    >
    <SidebarProvider>
      <AppSidebar data={data}/>
      <main>
        <SidebarTrigger/>
        {children}
      </main>
    </SidebarProvider>
    </body>
    </html>
  );
}
